# bank-account-micro-service
Remarque:
quand vous modifier (par exemple) la configuration dans config-service, il faut refraichir le service concerné à l'aide d'actuator via une requete POST:
POST http://localhost:8888/CUSTOMER-SERVICE/actuator/refresh
Accept: application/json