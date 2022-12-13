import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})

export class SalesComponent implements OnInit {

  dataSource: any;
  displayedColumns: string[] = [];
  tableDataSource: any;

  constructor(public router: Router) {

    this.dataSource= [{

      "column": [
        { "header": "Product ID", "field": "productID" },
        { "header": "Product name", "field": "productName" },
        {
          "header": "Sales", "subHeaders": [
            { "header": "2019Q1", "field": "salesQ1" },
            { "header": "2019Q2", "field": "salesQ2" },
            { "header": "2019Q3", "field": "salesQ3" },
            { "header": "2019Q4", "field": "salesQ4" }
          ]
        },
        { "header": "Total sales" }
      ],
      "data": [
        {
          "productID": "5068764589210",
          "productName": "Yukon Gold Potatos",
          "salesQ1": 120005,
          "salesQ2": 184557,
          "salesQ3": 150624,
          "salesQ4": 109383
        },
        {
          "productID": "5746890234585",
          "productName": "Butte Russet Potatos ",
          "salesQ1": 24005,
          "salesQ2": 284500,
          "salesQ3": 290657,
          "salesQ4": 350022
        },
        {
          "productID": "5449873501259",
          "productName": "Red Cloud Potatos",
          "salesQ1": 97800,
          "salesQ2": 85300,
          "salesQ3": 87458,
          "salesQ4": 100000
        },
        {
          "productID": "5639814580025",
          "productName": "Charlotte Potatos",
          "salesQ1": 97800,
          "salesQ2": 85300,
          "salesQ3": 87458,
          "salesQ4": 100000
        }
      ]
    }];

    this.tableDataSource = new MatTableDataSource(this.dataSource[0].data);

    this.displayedColumns = [
      this.dataSource[0].column[0].field,
      this.dataSource[0].column[1].field,
      this.dataSource[0].column[2].subHeaders[0].field,
      this.dataSource[0].column[2].subHeaders[1].field,
      this.dataSource[0].column[2].subHeaders[2].field,
      this.dataSource[0].column[2].subHeaders[3].field,
      'total'
    ];
  }

  ngOnInit() {

    const allSales = this.getSales('all');

    if (allSales) {
      this.dataSource[0].data = allSales
    }

    const newSale = this.getSales('newSale');

    if (newSale) {
      const dataLength = this.dataSource[0].data.length;
      this.dataSource[0].data[dataLength] = newSale;
      this.tableDataSource = new MatTableDataSource(this.dataSource[0].data);
      sessionStorage.removeItem('newSale');
      sessionStorage.setItem('all', JSON.stringify(this.dataSource[0].data));
    }
  }

  private getSales(key: string){

    const sale = sessionStorage.getItem(key);

    if(!sale){
      return null;
    } else {
      return JSON.parse(sale);
    }
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.tableDataSource.filter = filterValue.trim().toLowerCase();
  }

  sortData(sort: Sort) {
    const data = this.dataSource.slice();
    if (!sort.active || sort.direction === '') {
      return;
    }

    this.dataSource[0].data = data[0].data.sort((a: { productID: string | number | Date; productName: string | number | Date; salesQ1: string | number | Date; salesQ2: string | number | Date; salesQ3: string | number | Date; salesQ4: string | number | Date; }, b: { productID: string | number | Date; productName: string | number | Date; salesQ1: string | number | Date; salesQ2: string | number | Date; salesQ3: string | number | Date; salesQ4: string | number | Date; }) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case this.dataSource[0].column[0].field: return compare(a.productID, b.productID, isAsc);
        case this.dataSource[0].column[1].field: return compare(a.productName, b.productName, isAsc);
        case this.dataSource[0].column[2].subHeaders[0].field: return compare(a.salesQ1, b.salesQ1, isAsc);
        case this.dataSource[0].column[2].subHeaders[1].field: return compare(a.salesQ2, b.salesQ2, isAsc);
        case this.dataSource[0].column[2].subHeaders[2].field: return compare(a.salesQ3, b.salesQ3, isAsc);
        case this.dataSource[0].column[2].subHeaders[3].field: return compare(a.salesQ4, b.salesQ4, isAsc);
        default: return 0;
      }
    });
    this.tableDataSource = new MatTableDataSource(this.dataSource[0].data);
  }

  goToProduct() {
    this.router.navigate(['/product']);
  }
}

function compare(a: number | string | Date, b: number | string | Date, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}