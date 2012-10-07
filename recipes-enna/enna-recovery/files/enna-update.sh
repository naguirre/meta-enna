#!/bin/sh

package=""
current_version="`lsb_release -v`"
current_codename="`lsb_release -c`"
current_id="`lsb_release -i`"

if [ $current_id -ne "ennaos" ]; then
    echo "Bad platform"
    exit 1
fi

mkdir -p /media/mmc1
mkdir -p /media/mmc2

mount /dev/mmcblk0p1 /media/mmc1
mount /dev/mmcblk0p2 /media/mmc2

for i in mmc1 mmc2; do
    if [ -f /media/$i/update.txt ]; then
        version="$(awk NR==3 /media/$i/update.txt)"
        codename="$(awk NR==2 /media/$i/update.txt)"
        date="$(awk NR==4 /media/$i/update.txt)"
        id="$(awk NR==1 /media/$i/update.txt)"
        if [[ "$version" -gt "$current_version" ]]; then
            package="/media/$i/$(awk NR==5 /media/$i/update.txt)"
        else
            echo "Your current version ($current_version) is uptodate"
        fi
    else
    echo "no update.txt found in /media/$i"
    fi
done




