import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Bee} from '../models/bee.model';

@Injectable()
export class BeeService {
  private serviceUrl = 'http://localhost:8080/hiveMind/getBeeTags';

  constructor(private http: HttpClient) { }

  getBees(): Observable<Bee[]> {
    return this.http.get<Bee[]>(this.serviceUrl);
  }
}
