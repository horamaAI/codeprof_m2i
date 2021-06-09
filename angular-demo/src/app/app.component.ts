import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular-demo';
  produits = [
    { id: 1, libelle: "toto" },
    { id: 2, libelle: "toto 2" }
  ];

  async ngOnInit() {
    this.produits = await fetch("http://localhost:8080/eshop-web/api/produit")
                          .then(resp => resp.json());
  }













  async test() {
    this.produits = await fetch("http://localhost:8080/eshop-web/api/produit")
                          .then(resp => resp.json());
  }
}
