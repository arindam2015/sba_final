import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Http, Response } from "@angular/http";
import { Observable } from 'rxjs';
import { Gipher } from '../model/gipher';
import { map } from 'rxjs/operators';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class GipherService {
private api_url:string;
private api_key:string;
private backend_url:string;
private recommended_url:string;

  constructor(private http: Http,private router: Router,private httpClient:HttpClient,private authservice:AuthenticationService) {
        this.api_url="https://api.giphy.com/v1/gifs";
        this.api_key="QPayNCt8xoMomlYfVdySXOEGxAxXfiV2";
        //this.backend_url="http://localhost:6078/gify/v1";
        //local
        this.backend_url="http://localhost:8765/gipher-manager/gify/v1";
        this.recommended_url="http://localhost:8765/gipher-recommandation/gify/v1";
       //docker
        //this.backend_url="http://10.0.75.2:8765/gipher-manager/gify/v1";
        //this.recommended_url="http://10.0.75.2:8765/gipher-recommandation/gify/v1";
      }
   getAllGipher(){
    return this.http.get(this.api_url+"/trending?api_key="+this.api_key+"&limit=20").pipe(map((response:Response)=>response.json()));
    
       
    }
    getSearchGipher(searchValue:string){
      return this.http.get(this.api_url+"/search?api_key="+this.api_key+"&q="+searchValue+"&limit=20").pipe(map((response:Response)=>response.json()));
    }
    addToFavourite(id:string,title:string,url:string,addedBy:string):Observable<Gipher>{
      console.log("inside service id:"+id+" title:"+title+"url::"+url+" User:"+addedBy);
      const gipherData={gipherId:id,gipherTitle:title,gipherUrl:url,addedBy:addedBy};
      return this.httpClient.post<Gipher>(this.backend_url+"/addFavourite",gipherData,
      {
        headers:new HttpHeaders().set('Authorization',`${this.authservice.getBearerToken()}`)
      })

    }
    deleteBookmarkGipherById(gipherId:string,username:String):Observable<Gipher>{
      console.log("inside delete service id:"+gipherId+" username::"+username);
      //const gipherData={gipherId:gipherId,addedBy:username};
      return this.httpClient.delete<Gipher>(this.backend_url+"/bookmark/"+username+"/"+gipherId,
      {
        headers:new HttpHeaders().set('Authorization',`${this.authservice.getBearerToken()}`)
      });

    }
    getAllBookmark(userName:string){
     
      return this.httpClient.get<Gipher[]>(this.backend_url+"/allBookmarkGipher/"+userName,
      {
        headers:new HttpHeaders().set('Authorization',`${this.authservice.getBearerToken()}`)
      });
    }
    getRecommendedCount():Observable<Gipher[]>{
      console.log('inside recommended service');
      return this.httpClient.get<Gipher[]>(this.recommended_url+"/reminderListCount/",
      {
        headers:new HttpHeaders().set('Authorization',`${this.authservice.getBearerToken()}`)
      });
    }
}
