#!/bin/bash
DEVICE=leo
VENDOR=sony

MY_DIR="${BASH_SOURCE%/*}"
if [ ! -d "$MY_DIR" ]; then MY_DIR="$PWR"; fi

ANDROID_ROOT="${MY_DIR}/../../.."

source "${ANDROID_ROOT}/device/${VENDOR}/${DEVICE}/setup-makefiles.sh"

echo "Extraer blobs desde el teléfono con ADB..."

adb root
adb remount

while read -r file; do
adb pull "/$file" "${ANDROID_ROOT}/vendor/${VENDOR}/${DEVICE}/proprietary/$file"
done < proprietary-files.txt

echo "Blobs Extraídos"
