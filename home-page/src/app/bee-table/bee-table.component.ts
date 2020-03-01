import { Component, OnInit } from '@angular/core';
import { BeeService } from '../services/bee.service';
//import {Observable} from 'rxjs/Observable';
import {DataSource} from '@angular/cdk/collections';
import {Bee} from '../models/bee.model';
import { from } from 'rxjs';
import {Observable} from 'rxjs/Rx';
import { interval } from 'rxjs';
import { takeWhile } from 'rxjs/operators';


@Component({
  selector: 'app-bee-table',
  templateUrl: './bee-table.component.html',
  styleUrls: ['./bee-table.component.scss']
})
export class BeeTableComponent implements OnInit {

  dataSource;
  terminateIntervalSubscription = false;
  displayedColumns = ['id', 'speed', 'latitude', 'longitude', 'altitude', 'fuel', 'damage', 'nectar', 'honey'];
  beeInformation: Bee;

  constructor(private beeService: BeeService) { }

 
   ngOnInit(){
    interval(2000)
      .pipe(takeWhile(() => !this.terminateIntervalSubscription)).subscribe( () => {
        this.beeService.getBees().subscribe(data => this.dataSource = data);
      });
  }

}

// export class BeeDataSource extends DataSource<any> {
//   constructor(private beeService: BeeService) {
//     super();
//   }

//   connect(): Observable<Bee[]> {
//     return this.beeService.getBees();
//   }
//   disconnect() {}
// }
