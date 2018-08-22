<<<<<<< HEAD
import 'hammerjs';
=======
<<<<<<< HEAD
=======
import 'hammerjs';
>>>>>>> 5982038d65e576e1e833306c2294636a2478ce34
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.log(err));
