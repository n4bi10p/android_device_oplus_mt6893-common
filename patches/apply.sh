#!/bin/bash

DEVICE=mt6893-common
VENDOR=oplus

export originalPath=$(pwd)/device/$VENDOR/$DEVICE/patches/

applyPatches() {
    export counter=0

    cd $originalPath
    for i in $(ls -d */); do
        path=$(tr _ / <<< "$i")
        cd $originalPath
        cd ./../../../../"$path"
        git am "$originalPath"/"$i"*.patch
        [[ $? -ne 0 ]] && (( counter++ ))
        git am --abort &> /dev/null
    done
    
    echo "* Missed patches: $counter"
}

applyPatches

echo -e "\e[36m* Apply patches done!\e[m"
