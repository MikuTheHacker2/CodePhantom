DEVICE=leo
VENDOR=sony

VENDOR_MK="../../vendor/${VENDOR}/${DEVICE}/leo-vendor.mk"

while read -r file; do
echo "vendor/${VENDOR}/${DEVICE}/proprietary/$file:system/$file\\" >> $VENDOR_MK
done < proprietary-files.txt
