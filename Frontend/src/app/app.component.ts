import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormulaireComponent } from './layout/Formulaire/formulaire/formulaire.component';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ToastModule } from 'primeng/toast';
import { HeaderComponent } from './layout/header/header/header.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ToastModule, HeaderComponent, ConfirmDialogModule, FormulaireComponent,RouterOutlet],
  templateUrl: './app.component.html', 
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Formulaire';
}
