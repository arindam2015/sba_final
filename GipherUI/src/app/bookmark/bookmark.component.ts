import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { GipherService } from '../services/gipher.service';
import { Gipher } from '../model/gipher';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-bookmark',
  templateUrl: './bookmark.component.html',
  styleUrls: ['./bookmark.component.css']
})
export class BookmarkComponent implements OnInit {
  gipherBookmark:Gipher[];
  userName:string;
  constructor(public gipherService:GipherService,public authservice:AuthenticationService, private routerservice:RouterService) { }

  ngOnInit() {
    this.userName=this.authservice.getName();
    this.gipherService.getAllBookmark(this.userName).subscribe(
      response=>{
        console.log("bookmark response::"+response);
        this.gipherBookmark=response;
      },
      error=>{
        console.log("error bookmark "+error);
      }      
    )
  }
  onClickDelete(id:string){
    console.log('gipher id::'+id+' username:'+this.userName);
    this.gipherService.deleteBookmarkGipherById(id,this.userName).subscribe(
      response=>{
        console.log('deleted:'+response);
        this.routerservice.routeToDashboard();
      },
      error=>{
        console.log("error:"+error);
      }
    )
  }

}
