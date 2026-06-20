import { chromium } from 'playwright';
import { writeFileSync } from 'fs';
import { join } from 'path';
import { fileURLToPath } from 'url';

const __dirname = fileURLToPath(new URL('.', import.meta.url));
const SCREENSHOT_DIR = join(__dirname, 'screenshots');
const BASE = 'http://localhost:4200';
const W = 1366;
const H = 768;

const FAKE_TOKEN = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBjYXJlLmNvbSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTc1MDAwMDAwMH0.test';

const pages = [
  { name: 'login',            url: '/',              auth: false },
  { name: 'register',         url: '/register',      auth: false },
  { name: 'dashboard',        url: '/dashboard',     auth: true },
  { name: 'patients',         url: '/patients',      auth: true },
  { name: 'doctors',          url: '/doctors',       auth: true },
  { name: 'appointments',     url: '/appointments',  auth: true },
  { name: 'prescription',     url: '/prescriptions', auth: true },
  { name: 'medical-records',  url: '/medical-records', auth: true },
  { name: 'lab',              url: '/labs',           auth: true },
  { name: 'files',            url: '/files',          auth: true },
  { name: 'payment',          url: '/payments',       auth: true },
  { name: 'ai-checker',       url: '/ai-checker',     auth: true },
  { name: 'ai-summary',       url: '/ai-summary',     auth: true },
  { name: 'prescription-analyzer', url: '/prescription-analyzer', auth: true },
  { name: 'lab-report-analyzer',   url: '/lab-report-analyzer',   auth: true },
  { name: 'medical-ai-assistant',  url: '/medical-ai-assistant',  auth: true },
  { name: 'agentic-ai',      url: '/agentic-ai',    auth: true },
  { name: 'profile',          url: '/profile',       auth: true },
];

let browser;
try {
  browser = await chromium.launch({ headless: true });
  const context = await browser.newContext({ viewport: { width: W, height: H } });
  const results = [];

  for (const pDef of pages) {
    console.log(`📸 Capturing ${pDef.name}...`);
    const p = await context.newPage();

    if (pDef.auth) {
      await p.goto(BASE + '/login', { waitUntil: 'networkidle', timeout: 15000 }).catch(() => {});
      await p.evaluate((token) => { localStorage.setItem('token', token); }, FAKE_TOKEN);
    }

    await p.goto(BASE + pDef.url, { waitUntil: 'networkidle', timeout: 30000 }).catch(() => {});
    await p.waitForTimeout(2000);

    // Save as PNG
    const pngPath = join(SCREENSHOT_DIR, `${pDef.name}.png`);
    await p.screenshot({ path: pngPath, fullPage: false });
    
    const title = await p.title().catch(() => 'No title');
    const url = p.url();
    const status = url.includes(pDef.url.split('?')[0]) ? '✅' : '⚠️';
    results.push({ name: pDef.name, url, title, status });
    
    console.log(`  → ${status} ${pngPath}`);
    await p.close();
  }

  // Generate report
  const report = `# 🧪 End-to-End Screenshot Test Report

## Overview
Real browser screenshots captured using Playwright (Chromium) against the Angular frontend.

## Test Results

| # | Page | URL | Status |
|---|------|-----|--------|
${results.map((r, i) => `| ${i+1} | **${r.name}** | \`${r.url}\` | ${r.status} |`).join('\n')}

## Screenshots Captured: ${results.length}
All screenshots saved to \`screenshots/*.png\`.

## Test Environment
- **Browser**: Chromium (headless)
- **Viewport**: ${W}x${H}
- **Frontend**: Angular 21 (dev server @ ${BASE})
- **Backend APIs**: Not running (UI structural screenshots)
- **Auth**: Fake JWT token injected for protected routes

## Captured Pages
${results.map(r => `- ${r.status} ${r.name}`).join('\n')}

---
*Report generated: ${new Date().toISOString()}*
`;

  writeFileSync(join(__dirname, 'TESTING_REPORT_E2E.md'), report);
  console.log('\n✅ All screenshots captured!');
  console.log(`📄 Report: TESTING_REPORT_E2E.md`);

} catch (err) {
  console.error('❌ Error:', err.message);
} finally {
  if (browser) await browser.close();
}
