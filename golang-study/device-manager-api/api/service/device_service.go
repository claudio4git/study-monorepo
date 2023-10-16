package service

import (
	"github.com/gorilla/mux"
	"github.com/jclaudiocf/do-go/device-manager-api/api/model"
	"github.com/jclaudiocf/do-go/device-manager-api/api/repository"
	"github.com/jclaudiocf/do-go/device-manager-api/api/util"
	uuid "github.com/satori/go.uuid"
	"net/http"
	"strconv"
)

func CreateDevice(w http.ResponseWriter, device *model.Device) error {
	device.ID = uuid.NewV4()

	err := repository.InsertDevice(device)
	util.HttpErrorChecking(w, err, "create device", http.StatusInternalServerError)

	return err
}

func UpdateDevice(w http.ResponseWriter, r *http.Request, device *model.Device) error {
	params := mux.Vars(r)
	var err error

	if device.ID, err = uuid.FromString(params["id"]); err != nil {
		util.HttpErrorChecking(w, err, "covert id from string params", http.StatusInternalServerError)
		return err
	}

	if err := repository.ExistsDeviceById(device.ID); err != nil {
		util.HttpErrorChecking(w, err, "find device by id", http.StatusNotFound)
		return err
	}

	err = repository.UpdateDevice(device)
	util.HttpErrorChecking(w, err, "update device", http.StatusInternalServerError)

	return err
}

func DeleteDevice(w http.ResponseWriter, params map[string]string) error {
	var id = uuid.UUID{}
	var err error

	if id, err = uuid.FromString(params["id"]); err != nil {
		util.HttpErrorChecking(w, err, "covert id from string params", http.StatusInternalServerError)
		return err
	}

	if err := repository.ExistsDeviceById(id); err != nil {
		util.HttpErrorChecking(w, err, "find device by id", http.StatusNotFound)
		return err
	}

	err = repository.DeleteDevice(id)
	util.HttpErrorChecking(w, err, "delete device", http.StatusInternalServerError)

	return err
}

func Retrieve(w http.ResponseWriter, params map[string]string, device *model.Device) error {
	var id = uuid.UUID{}
	var err error

	if id, err = uuid.FromString(params["id"]); err != nil {
		util.HttpErrorChecking(w, err, "covert id from string params", http.StatusInternalServerError)
		return err
	}

	if err := repository.ExistsDeviceById(id); err != nil {
		util.HttpErrorChecking(w, err, "find device by id", http.StatusNotFound)
		return err
	}

	device.ID = id

	err = repository.FindDeviceById(device)
	util.HttpErrorChecking(w, err, "retrieve device", http.StatusInternalServerError)

	return err
}

func List(w http.ResponseWriter, params map[string]string, devicePageable *model.DevicePageable) error {
	var err error
	var page, size int

	if page, err = strconv.Atoi(params["page"]); err != nil {
		util.HttpErrorChecking(w, err, "page param invalid", http.StatusNotFound)
		return err
	}

	if size, err = strconv.Atoi(params["size"]); err != nil {
		util.HttpErrorChecking(w, err, "size param invalid", http.StatusNotFound)
		return err
	}

	devicePageable.Page = page
	devicePageable.Size = size
	devicePageable.Devices = &[]model.Device{}

	repository.ListDevices(devicePageable)

	return nil
}