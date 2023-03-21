import { Injectable, NgZone } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
@Injectable({
    providedIn: 'root',
  })
  export class SnackbarService {
    static SNACKBAR_SHOW_DURATION_MS = 4000;
  
    constructor(private snackbar: MatSnackBar, private ngZone: NgZone) {}
  
    success(message: string) {
      this.ngZone.run(() => {
        this.snackbar.open(message, 'Success', {
          duration: SnackbarService.SNACKBAR_SHOW_DURATION_MS,
        });
      });
    }
  
    error(message: string) {
      this.ngZone.run(() => {
        this.snackbar.open(message, 'Error', {
          duration: SnackbarService.SNACKBAR_SHOW_DURATION_MS,
        });
      });
    }
  
    info(message: string) {
      this.ngZone.run(() => {
        this.snackbar.open(message, 'Info', {
          duration: SnackbarService.SNACKBAR_SHOW_DURATION_MS,
        });
      });
    }
  }
  