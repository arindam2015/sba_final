import { Component, OnInit } from '@angular/core';
import { GipherService } from '../services/gipher.service';
import { AuthenticationService } from '../services/authentication.service';
import { Gipher } from '../model/gipher';

@Component({
  selector: 'app-recommand',
  templateUrl: './recommand.component.html',
  styleUrls: ['./recommand.component.css']
})
export class RecommandComponent implements OnInit {
  gipherRecommend:Gipher[];
  
    constructor(public gipherService:GipherService,public authservice:AuthenticationService) { }

  ngOnInit() {
    this.gipherService.getRecommendedCount().subscribe(
      data=>{
        console.log("response:"+data);
        this.gipherRecommend=data;
      
      },
      err=>{
        console.log('error::'+err);
      }

      
    )
  }

}
