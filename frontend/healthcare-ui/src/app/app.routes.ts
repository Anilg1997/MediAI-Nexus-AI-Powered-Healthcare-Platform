import { Routes } from '@angular/router';

import { LoginComponent }
from './pages/login/login';

import { RegisterComponent }
from './pages/register/register';

import { DashboardComponent }
from './pages/dashboard/dashboard';

import { PatientComponent }
from './pages/patient/patient';

import { DoctorComponent }
from './pages/doctor/doctor';
import { AppointmentComponent }
from './pages/appointment/appointment';

import { AiCheckerComponent }
from './pages/ai-checker/ai-checker';

import { PrescriptionComponent }
from './pages/prescription/prescription';

import { MedicalRecordComponent }
from './pages/medical-record/medical-record';

import { LabComponent }
from './pages/lab/lab';

import { FilesComponent }
from './pages/files/files';

import { PaymentComponent }
from './pages/payment/payment';

import { AiSummaryComponent } from './ai-summary/ai-summary';

import { PrescriptionAnalyzerComponent }
from './prescription-analyzer/prescription-analyzer';

import { LabReportAnalyzerComponent }
from './lab-report-analyzer/lab-report-analyzer';

import { MedicalAiAssistantComponent }
from './medical-ai-assistant/medical-ai-assistant';

import {
  authGuard
} from './guards/auth-guard';

import { ProfileComponent } from './pages/profile/profile';

export const routes: Routes = [

  {
    path: '',
    component: LoginComponent
  },
  {
  path: 'login',
  component: LoginComponent

},

  {
    path: 'register',
    component: RegisterComponent
  },

  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [
    authGuard
  ]
  },

  {
    path: 'patients',
    component: PatientComponent,
    canActivate: [
    authGuard
  ]
  },

  {
    path: 'doctors',
    component: DoctorComponent,
    canActivate: [
    authGuard
  ]
  },
  {
  path: 'appointments',
  component: AppointmentComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'ai-checker',
  component: AiCheckerComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'prescriptions',
  component: PrescriptionComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'medical-records',
  component: MedicalRecordComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'labs',

  component: LabComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'files',

  component: FilesComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'payments',

  component: PaymentComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'ai-summary',
  component: AiSummaryComponent,
  canActivate: [
    authGuard
  ]
},
{
    path: 'prescription-analyzer',
    component: PrescriptionAnalyzerComponent,
    canActivate: [
    authGuard
  ]
  },
  {
  path: 'lab-report-analyzer',
  component: LabReportAnalyzerComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'medical-ai-assistant',
  component:
    MedicalAiAssistantComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'agentic-ai',
  component:
    MedicalAiAssistantComponent,
  canActivate: [
    authGuard
  ]
},
{
  path: 'profile',
  component: ProfileComponent,
  canActivate: [
    authGuard
  ]
}
];