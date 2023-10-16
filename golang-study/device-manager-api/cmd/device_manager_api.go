package main

import (
	"github.com/gorilla/mux"
	"github.com/jclaudiocf/do-go/device-manager-api/api/handler"
	"github.com/jclaudiocf/do-go/device-manager-api/api/repository"
	"log"
	"net/http"
)

func main() {
	// Start database connection and make migrations
	repository.InitMigrations()

	// Configure the routes
	router := mux.NewRouter()
	router.HandleFunc("/device", handler.ListDevicesHandler).Methods("GET").Queries("page", "{page}", "size", "{size}")
	router.HandleFunc("/device", handler.CreateDeviceHandler).Methods("POST")
	router.HandleFunc("/device/{id}", handler.RetrieveDeviceHandler).Methods("GET")
	router.HandleFunc("/device/{id}", handler.UpdateDeviceHandler).Methods("PUT")
	router.HandleFunc("/device/{id}", handler.DeleteDeviceHandler).Methods("DELETE")

	// Other configurations
	router.Use(mux.CORSMethodMiddleware(router))

	// Start API
	log.Fatal(http.ListenAndServe(":8000", router))
}
