import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideAnimations } from '@angular/platform-browser/animations';
import { NgChartsModule } from 'ng2-charts'; // ✅ works now with v8

export const appConfig: ApplicationConfig = {
  providers: [
    provideAnimations(),
    provideRouter([]),
    importProvidersFrom(NgChartsModule), // ✅ inject the module
  ],
};
