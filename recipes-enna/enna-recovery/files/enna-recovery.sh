#!/bin/sh

/usr/bin/nand-part > /tmp/nand-part.output
diff /usr/share/enna-recovery/nand-part.output /tmp/nand-part.output

if [ $? -eq 1 ]; then
    # nand part is not correct
    # Save nandh if it exists, it contains the macadress
    if [ -f /dev/nandh ]; then
	dd if=/dev/nandh of=/tmp/nandh.bin bs=512 count=4096
	eval `grep "mac=" /tmp/nandh.bin`
	echo $mac
	mkdir -p /tmp/nanda
	mount /dev/nanda /tmp/nanda
	echo $mac > /tmp/nanda/mac_address
    fi

    # create the right partition table and reboot the machine.
    dd  if=/usr/share/enna-recovery/nand.bin of=/dev/nand count=1 bs=2048
    /usr/bin/nand-part > /tmp/nand-part.output
    diff /usr/share/enna-recovery/nand-part.output /tmp/nand-part.output
    if [ $? -eq 1 ]; then
        echo "I don't know what to do here, /dev/nand seems not usable. It's an unrecoverable error, exiting"
    fi
    /sbin/reboot
fi

mkdir -p /tmp/nanda
mount /dev/nanda /tmp/nanda
mac=`cat /tmp/nanda/mac_address`
cp /usr/share/enna-recovery/nandb.bin /tmp/nandb.bin
sed -i -e "s/00:00:00:00:00:00/$mac/g" /tmp/nandb.bin
umount /dev/nanda

echo "Recovery of (nanda)"
dd if=/usr/share/enna-recovery/nanda.bin of=/dev/nanda


echo "Recovery of (nandb)"
dd if=/tmp/nandb.bin of=/dev/nandb



echo "Formatting Home partition (nandc)"
/sbin/mkfs.ext4 /dev/nandc

package=""

for i in  `ls /*.pkg`
do
    if [ "x$i" -eq "xupdate.pkg" ]; then
        update=$i
        break
    fi
done

if [ $updated -eq 0 ]; then



fi

echo "Copy image on rootfs1 (nandd)"
dd if=$package of=/dev/nandd
echo "Copy image on rootfs2 (nande)"
dd if=$package of=/dev/nande

echo "Formatting updates partition (nandf)"
/sbin/mkfs.ext4 /dev/nandf



