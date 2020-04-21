Goal of this API is to provide information on artists, albums and release year.


This API has below mentioned End points


/api/v1/artists  : This end point provides list of artists.


/api/v1/artists  : Create a new artist object.


/api/v1/artists/{artistId} : Update a exxisiting artist object.


/api/v1/artists/{artistId}/albums : Get albums by artist.


/api/v1/artists/{artistId}/albums : Create a new album object.


/api/v1/artists/{artistId}/albums/{albumId} : Modify an existing album object.


/api/v1/artists/{artistId}/albums/{albumId} : Fetch an album from an artist.

 
/actuator/health : Health check end point


/swagger-ui.html : Swagger end point


/console : h2 database end point



Details about h2 database :

--------------------------

JDBC-URL : jdbc:h2:mem:musicdb

Username : music


---------------------------


Local profile of application is activated. No changes needed to deploy the applcation in localhost.


Application context : musicportal


Swagger for localhost :  http://localhost:8080/musicportal/swagger-ui.html


http://localhost:8080/musicportal/console/

