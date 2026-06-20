#!/usr/bin/env bash
#=============================================================================
# End-to-End Test Script for MediAI Nexus
# Tests frontend availability and backend API endpoints
#=============================================================================

set -e

BASE_URL="${1:-http://localhost:4200}"
API_URL="${2:-http://localhost:8080}"
PASS=0
FAIL=0
TOTAL=0

green() { echo -e "\033[32m$1\033[0m"; }
red()   { echo -e "\033[31m$1\033[0m"; }
bold()  { echo -e "\033[1m$1\033[0m"; }

check() {
    TOTAL=$((TOTAL + 1))
    if [ "$1" -eq 0 ]; then
        PASS=$((PASS + 1))
        green "  ✅ $2"
    else
        FAIL=$((FAIL + 1))
        red "  ❌ $2"
    fi
}

#=============================================================================
bold "🧪 MediAI Nexus — End-to-End Test Suite"
bold "========================================"
echo ""

#-------------------------------------------------------------------------
bold "1. Frontend Availability"
#-------------------------------------------------------------------------
curl -s -o /dev/null -w "%{http_code}" "$BASE_URL" | grep -q "200" && RC=0 || RC=1
check $RC "Frontend is reachable at $BASE_URL"

curl -s "$BASE_URL" | grep -qi "medi-ai-nexus\|MediAI\|healthcare\|login" && RC=0 || RC=1
check $RC "Frontend serves Angular application"

#-------------------------------------------------------------------------
bold ""
bold "2. Backend API Endpoints (requires running services)"
#-------------------------------------------------------------------------
if curl -s -o /dev/null -w "%{http_code}" "$API_URL/actuator/health" --max-time 5 | grep -q "200"; then
    API_UP=true
    green "  ℹ️  API Gateway is UP at $API_URL"
else
    API_UP=false
    echo "  ⚠️  API Gateway not reachable — skipping API tests"
fi

if [ "$API_UP" = true ]; then
    # Health check
    curl -s "$API_URL/actuator/health" | grep -q "UP" && RC=0 || RC=1
    check $RC "API Gateway health is UP"

    # Login endpoint
    LOGIN_RESP=$(curl -s -X POST "$API_URL/api/auth/login" \
        -H "Content-Type: application/json" \
        -d '{"username":"admin","password":"admin"}' --max-time 10)
    echo "$LOGIN_RESP" | grep -q "token" && RC=0 || RC=1
    check $RC "Authentication endpoint returns JWT token"

    TOKEN=$(echo "$LOGIN_RESP" | grep -o '"token":"[^"]*"' | cut -d'"' -f4)

    if [ -n "$TOKEN" ]; then
        # Protected endpoints
        curl -s "$API_URL/api/patients" -H "Authorization: Bearer $TOKEN" --max-time 10 | grep -q "\[" && RC=0 || RC=1
        check $RC "Patients endpoint returns data"

        curl -s "$API_URL/api/doctors" -H "Authorization: Bearer $TOKEN" --max-time 10 | grep -q "\[" && RC=0 || RC=1
        check $RC "Doctors endpoint returns data"

        curl -s "$API_URL/api/appointments" -H "Authorization: Bearer $TOKEN" --max-time 10 | grep -q "\[" && RC=0 || RC=1
        check $RC "Appointments endpoint returns data"

        # AI endpoints
        curl -s -X POST "$API_URL/api/ai/chat" \
            -H "Content-Type: application/json" \
            -H "Authorization: Bearer $TOKEN" \
            -d '{"question":"Hello"}' --max-time 30 | grep -q . && RC=0 || RC=1
        check $RC "AI Chat endpoint responds"

        curl -s -X POST "$API_URL/api/ai/symptom-checker" \
            -H "Content-Type: application/json" \
            -H "Authorization: Bearer $TOKEN" \
            -d '{"symptoms":"fever,headache"}' --max-time 30 | grep -q . && RC=0 || RC=1
        check $RC "Symptom Checker endpoint responds"

        curl -s -X POST "$API_URL/api/ai/summarize" \
            -H "Content-Type: application/json" \
            -H "Authorization: Bearer $TOKEN" \
            -d '{"report":"Patient has fever and cough"}' --max-time 30 | grep -q . && RC=0 || RC=1
        check $RC "Report Summarization endpoint responds"

        curl -s -X POST "$API_URL/api/ai/analyze-prescription" \
            -H "Content-Type: application/json" \
            -H "Authorization: Bearer $TOKEN" \
            -d '{"prescription":"Amoxicillin 500mg"}' --max-time 30 | grep -q . && RC=0 || RC=1
        check $RC "Prescription Analysis endpoint responds"

        curl -s -X POST "$API_URL/api/ai/rag-chat" \
            -H "Content-Type: application/json" \
            -H "Authorization: Bearer $TOKEN" \
            -d '{"question":"What is diabetes?"}' --max-time 30 | grep -q . && RC=0 || RC=1
        check $RC "RAG Chat endpoint responds"

        curl -s -X POST "$API_URL/api/agent/orchestrate" \
            -H "Content-Type: application/json" \
            -H "Authorization: Bearer $TOKEN" \
            -d '{"query":"I have fever and need a doctor"}' --max-time 60 | grep -q . && RC=0 || RC=1
        check $RC "Agentic AI Orchestration endpoint responds"
    fi
fi

#-------------------------------------------------------------------------
bold ""
bold "3. Frontend Page Load Tests"
#-------------------------------------------------------------------------
PAGES=("/" "/register" "/dashboard" "/patients" "/doctors" "/appointments"
       "/prescriptions" "/medical-records" "/labs" "/files" "/payments"
       "/ai-checker" "/ai-summary" "/prescription-analyzer" "/lab-report-analyzer"
       "/medical-ai-assistant" "/agentic-ai" "/profile")
for page in "${PAGES[@]}"; do
    STATUS=$(curl -s -o /dev/null -w "%{http_code}" "$BASE_URL$page" --max-time 10)
    if [ "$STATUS" = "200" ] || [ "$STATUS" = "302" ]; then
        PASS=$((PASS + 1))
        green "  ✅ $page -> $STATUS"
    else
        FAIL=$((FAIL + 1))
        red "  ❌ $page -> $STATUS"
    fi
    TOTAL=$((TOTAL + 1))
done

#=============================================================================
bold ""
bold "========================================"
bold "📊 Test Summary"
echo ""
green "  ✅ Passed: $PASS"
red "  ❌ Failed: $FAIL"
echo "  📝 Total:  $TOTAL"
bold "========================================"

if [ "$FAIL" -eq 0 ]; then
    green ""
    green "  🎉 ALL TESTS PASSED!"
else
    red ""
    red "  ⚠️  Some tests failed. Check details above."
fi
echo ""

exit $FAIL
