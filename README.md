# Velo-Rombit

## Backend service Velo

- call to velo api and returns the only the stations

- endpoint: http://localhost:8090/stations get


## Backend service station

- call to backend service Velo

- returns stations incl extra info (favorite)

- endpoints: 
1. http://localhost:8080/authenticate get
1. http://localhost:8080/stations/favorite/{stationId} post (with JWT only)
1. http://localhost:8080/stations/favorite/{stationId} delete (with JWT ony)


## Front end (featured)

openLayers

