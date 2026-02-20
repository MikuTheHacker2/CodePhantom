#!/bin/bash

# ===== CodePhantom OS Build Script =====

echo "Iniciando compilación de CodePhantom OS..."

# Cargar entorno Android
source build/envsetup.sh

# Limpiar compilaciones anteriores (opcional)
make clean

# Seleccionar dispositivo con root habilitado
lunch lineage_leo-userdebug

# Compilar ROM completa
make -j$(nproc)

echo "-------------------------------------"
echo "Build terminada."
echo "Archivos generados en:"
echo "out/target/product/leo/"
echo "-------------------------------------"
