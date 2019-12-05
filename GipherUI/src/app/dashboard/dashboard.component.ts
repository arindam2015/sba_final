import { Component, OnInit } from '@angular/core';
import { GipherService } from '../services/gipher.service';
import { Gipher } from '../model/gipher';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
title:string="Welcome to Giphy";
isSearched:boolean=false;
searchValue:string;
giphy:[];
addedBy: string;

  constructor(public gipherService:GipherService,public authservice:AuthenticationService) { }

  ngOnInit() {
    this.gipherService.getAllGipher().subscribe(
     (res)=>{
        console.log(res.data);
        this.giphy=res.data;
      }
    )    
  }
  onClickFav(id:string,title:string,url:string){
    console.log("id"+id+" title::"+title);
    this.addedBy=this.authservice.getName();
    this.gipherService.addToFavourite(id,title,url,this.addedBy).subscribe(
     (response:Gipher)=>{
        data=>{
          console.log("fav response:"+response);
        }
      },
      error=>{
          console.log(error);
      }
    )

  }
  onSearch(form: NgForm){
    if (form.invalid) {
      return;
    }
    console.log('serachValue:'+form.value.search);
    this.searchValue=form.value.search;
    this.gipherService.getSearchGipher(this.searchValue).subscribe(
      (response)=>{
        this.isSearched=true;
         console.log(response.data);
         this.giphy=response.data;
       }
     ) 
  }

}
