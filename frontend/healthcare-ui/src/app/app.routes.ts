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

export const routes: Routes = [

  {
    path: '',
    component: LoginComponent
  },

  {
    path: 'register',
    component: RegisterComponent
  },

  {
    path: 'dashboard',
    component: DashboardComponent
  },

  {
    path: 'patients',
    component: PatientComponent
  },

  {
    path: 'doctors',
    component: DoctorComponent
  },
  {
  path: 'appointments',
  component: AppointmentComponent
},
{
  path: 'ai-checker',
  component: AiCheckerComponent
},
{
  path: 'prescriptions',
  component: PrescriptionComponent
},
{
  path: 'medical-records',
  component: MedicalRecordComponent
},
{
  path: 'labs',

  component: LabComponent
},
{
  path: 'files',

  component: FilesComponent
},
{
  path: 'payments',

  component: PaymentComponent
}
];