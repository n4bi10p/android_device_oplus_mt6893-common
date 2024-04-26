#!/bin/bash

# Oplus camera
CAM=device/oplus/camera/camera.mk
if ! [ -a $CAM ]; then
    git clone https://gitlab.com/nattolecats/android_device_oplus_camera device/oplus/camera
fi

# Clang
CLANG17=prebuilts/clang/host/linux-x86/clang-r487747/bin/clang
if ! [ -a $CLANG17 ]; then
    git clone https://gitlab.com/nattolecats/android_prebuilts_clang_host_linux-x86_clang-r487747 prebuilts/clang/host/linux-x86/clang-r487747 --depth 1
fi

# KernelSU
KSU=kernel/oplus/mt6893/KernelSU
rm -rf $KSU && git clone https://github.com/tiann/KernelSU $KSU

# Source patches
bash device/oplus/mt6893-common/patches/apply.sh
