import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserHomeComponent } from './user-home/user-home.component';
import { ProductComponent } from './product/product.component';
import { RedeemComponent } from './redeem/redeem.component';



const routes: Routes = [
  {
    path: 'home',
    component: UserHomeComponent
  },
  {
    path: 'product',
    component: ProductComponent
  },
  {
    path: 'redeem',
    component: RedeemComponent
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
