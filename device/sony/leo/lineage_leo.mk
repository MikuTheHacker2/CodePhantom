PRODUCT_NAME := CodePhantom_leo

PRODUCT_DEVICE := leo
PRODUCT_BRAND := sony
PRODUCT_MODEL := Xperia Z3

PRODUCT_PACKAGES += CodePhantomShell

$(call inherit-product, device/sony/leo/device.mk)
$(call inherit-product, vendor/sony/leo/leo-vendor.mk)
