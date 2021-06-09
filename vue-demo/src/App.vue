<template>
  <div id="app">
TOUT A FAIT
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Libellé</th>
          <th>Prix</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="produit of produits" :key="produit.id">
          <td>{{ produit.id }}</td>
          <td>{{ produit.libelle }}</td>
          <td>{{ produit.prix }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'App',

  data() {
    return {
      msg: "Coucou tout le monde !",
      produits: [
        { id: 1, libelle: "toto" },
        { id: 2, libelle: "toto 2" }
      ]
    }
  },

  // mounted() {
  //   fetch("http://localhost:8080/eshop-web/api/produit") //Retourne une promesse JS
  //   // .then(resp => {
  //   //   return resp.json()
  //   // })
  //   .then(resp => resp.json()) //Aussi une promesse
  //   .then(produits => {
  //     console.log(produits);
  //     this.produits = produits;
  //   });
  // }


  async mounted() {
    this.produits = await fetch("http://localhost:8080/eshop-web/api/produit")
                          .then(resp => resp.json());
  }
  
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
