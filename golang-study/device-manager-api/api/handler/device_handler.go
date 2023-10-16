package handler

import (
	"encoding/json"
	"github.com/gorilla/mux"
	"github.com/jclaudiocf/do-go/device-manager-api/api/model"
	"github.com/jclaudiocf/do-go/device-manager-api/api/service"
	"net/http"
)

func CreateDeviceHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	var device model.Device

	_ = json.NewDecoder(r.Body).Decode(&device)

	if err := service.CreateDevice(w, &device); err == nil {
		_ = json.NewEncoder(w).Encode(&device)
	}
}

func UpdateDeviceHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	var device model.Device

	_ = json.NewDecoder(r.Body).Decode(&device)

	if err := service.UpdateDevice(w, r, &device); err == nil {
		_ = json.NewEncoder(w).Encode(&device)
	}
}

func DeleteDeviceHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")

	_ = service.DeleteDevice(w, mux.Vars(r))
}

func RetrieveDeviceHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	var device model.Device

	if err := service.Retrieve(w, mux.Vars(r), &device); err == nil {
		_ = json.NewEncoder(w).Encode(&device)
	}
}

func ListDevicesHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	var devicePageable = model.DevicePageable{}

	if err := service.List(w, mux.Vars(r), &devicePageable); err == nil {
		_ = json.NewEncoder(w).Encode(devicePageable)
	}
}