import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { LabService }
from '../../services/lab.service';

@Component({

  selector: 'app-lab',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './lab.html',

  styleUrl:
    './lab.css'
})

export class LabComponent {

  private labService =
    inject(LabService);

  reports: any[] = [];

  editMode = false;

  selectedReportId = 0;

  report = {

    patientId: '',

    doctorId: '',

    testName: '',

    testResult: '',

    reportUrl: '',

    status: '',

    testDate: ''
  };

  ngOnInit() {

    this.loadReports();
  }

  addReport() {

    if (this.editMode) {

      this.updateReport();

      return;
    }

    this.labService

      .addLabReport(this.report)

      .subscribe({

        next: () => {

          alert(
            'Lab Report Added');

          this.loadReports();

          this.resetForm();
        }
      });
  }

  loadReports() {

    this.labService

      .getLabReports()

      .subscribe({

        next: (data: any) => {

          this.reports = data;
        }
      });
  }

  editReport(report: any) {

    this.editMode = true;

    this.selectedReportId =
      report.id;

    this.report = {
      ...report
    };
  }

  updateReport() {

    this.labService

      .updateLabReport(

        this.selectedReportId,

        this.report

      )

      .subscribe({

        next: () => {

          alert(
            'Lab Report Updated');

          this.loadReports();

          this.resetForm();
        }
      });
  }

  deleteReport(id: number) {

    this.labService

      .deleteLabReport(id)

      .subscribe({

        next: () => {

          alert(
            'Lab Report Deleted');

          this.loadReports();
        }
      });
  }

  resetForm() {

    this.editMode = false;

    this.selectedReportId = 0;

    this.report = {

      patientId: '',

      doctorId: '',

      testName: '',

      testResult: '',

      reportUrl: '',

      status: '',

      testDate: ''
    };
  }
}