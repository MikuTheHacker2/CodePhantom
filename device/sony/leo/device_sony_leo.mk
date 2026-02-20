$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base.mk)

PRODUCT_NAME := codephantom_leo
PRODUCT_MODEL := CodePhantom Z3 Dev
PRODUCT_BRAND := CodePhantom
PRODUCT_DEVICE := leo
PRODUCT_MANUFACTURER := Sony

PRODUCT_PACKAGES += \
CodePhantomShell

PRODUCT_SYSTEM_DEFAULT_PROPERTIES += \
ro.secure=0 \
ro.debuggable=1 \
persist.sys.usb.config=adb
