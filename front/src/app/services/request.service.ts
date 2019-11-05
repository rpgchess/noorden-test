import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  baseUrl = 'http://localhost:8080';
  urls = {
    cliente: `${this.baseUrl}/clientes`,
    produto: `${this.baseUrl}/produtos`,
    venda: `${this.baseUrl}/vendas`
  };

  constructor() { }

  async getClientes() {
    return await fetch(this.urls.cliente, {
      method: 'get',
      headers: { "Accept": "application/json" }
    }).then(function (response) {
      return response.json();
    }).then(function (myJson) {
      return myJson;
    });
  }

  async getProdutos() {
    return await fetch(this.urls.produto, {
      method: 'get',
      headers: { "Accept": "application/json" }
    }).then(function (response) {
      return response.json();
    }).then(function (myJson) {
      return myJson;
    });
  }

  async getVendas() {
    return await fetch(this.urls.venda, {
      method: 'get',
      headers: { "Accept": "application/json" }
    }).then(function (response) {
      return response.json();
    }).then(function (myJson) {
      return myJson;
    });
  }

  async setVenda(idCliente: number, idProduto: number, valorTotal: number) {
    await fetch(this.urls.venda, {
      method: 'post',
      headers: { "Accept": "application/json", "Content-Type": "application/json" },
      body: JSON.stringify({codCliente: idCliente, codProduto: idProduto, valorTotal: valorTotal})
    }).then(function (response) {
      return response.json();
    }).then(function (myJson) {
      return myJson;
    });
  }
}
