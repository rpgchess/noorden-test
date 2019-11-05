import { RequestService } from './services/request.service';
// import { Http } from '@angular/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'noorden-front';

  vendas = [];
  venda = {
    clientes: [],
    produtos: [],
    cliente: { "id": 1, "nome": "Nenhum", "cpf": "", "dataNasc": "", "sexo": "" },
    produto: { "id": 1, "nome": "Nenhum", "valor": 1 },
    preco: 0.00,
    qtd: 1,
    total: 0.00
  }

  async onSubmit(form: NgForm) {
    this.req.setVenda(this.venda.cliente.id, this.venda.produto.id,this.venda.total);

    this.venda.cliente.id = 1;
    this.venda.produto.id = 1;
    this.venda.preco = 0.0;
    this.venda.qtd = 1;
    this.venda.total = 0.0;

    this.vendas = await Promise.resolve(this.req.getVendas());
  }

  constructor(private req: RequestService) {}

  async ngOnInit() {
    if (self.fetch) {
      this.venda.clientes = await Promise.resolve(this.req.getClientes());
      this.venda.produtos = await Promise.resolve(this.req.getProdutos());
    }
  }

  onChangeCliente(e) {
    let find: any = this.venda.clientes.filter(x => x.id == e );
    this.venda.cliente.id= find[0].id;
  }

  onChangeProduto(e) {
    let find: any = this.venda.produtos.filter(x => x.id == e );
    this.venda.preco = find[0].valor;
    this.venda.produto.id= find[0].id;
    this.venda.total = this.venda.preco * this.venda.qtd;
  }

  onChangeQtd(e) {
    this.venda.total = this.venda.preco * this.venda.qtd;
  }
}
