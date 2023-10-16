package repository

import (
	"errors"
	"fmt"
	"github.com/jclaudiocf/do-go/device-manager-api/api/model"
	"github.com/jinzhu/gorm"
	"github.com/satori/go.uuid"
)

func InsertDevice(entity *model.Device) error {
	db := GetConnection()
	defer db.Close()

	return db.Transaction(func(tx *gorm.DB) error {
		if err := tx.Create(&entity).Error; err != nil {
			return err
		}
		return nil
	})
}

func UpdateDevice(entity *model.Device) error {
	db := GetConnection()
	defer db.Close()

	return db.Transaction(func(tx *gorm.DB) error {
		if err := tx.Model(entity).Update(entity).Error; err != nil {
			return err
		}
		return nil
	})
}

func DeleteDevice(id uuid.UUID) error {
	db := GetConnection()
	defer db.Close()

	return db.Transaction(func(tx *gorm.DB) error {
		if err := tx.Where("id = ?", id).Delete(model.Device{}).Error; err != nil {
			return err
		}
		return nil
	})

}

func FindDeviceById(device *model.Device) error {
	db := GetConnection()
	defer db.Close()

	db.Where("id = ?", device.ID).First(&device)

	if device.ID == uuid.Nil {
		return errors.New(fmt.Sprintf("Device uuid %s not found", device.ID))
	}

	return nil
}

func ListDevices(devicePageable *model.DevicePageable) {
	db := GetConnection()
	defer db.Close()

	db.Offset(devicePageable.Page).Limit(devicePageable.Size).Order("nickname").Find(devicePageable.Devices)
}

func ExistsDeviceById(id uuid.UUID) error {
	var count int64
	db := GetConnection()
	defer db.Close()

	db.Table("devices").Where("id = ?", id).Count(&count)

	if count == 0 {
		return errors.New(fmt.Sprintf("Device uuid %s not found", id))
	}

	return nil
}
