#!/bin/sh

/usr/bin/nand-part > /tmp/nand-part.output
diff /usr/share/enna-recovery/nand-part.output /tmp/nand-part.output

if [ $? -eq 1 ]; then
    # nand part is not correct, create the right partition table and reboot the machine.
    dd if=/dev/nand of=/usr/share/enna-recovery/nand.bin count=1 bs=2048
    /usr/bin/nand-part > /tmp/nand-part.output
    diff /usr/share/enna-recovery/nand-part.output /tmp/nand-part.output
    if [ $? -eq 1 ]; then
        echo "I don't know what to do here, /dev/nand seems not usable. It's an unrecoverable error, exiting"
    fi
    /sbin/reboot
fi

echo "Recovery of (nanda)"
dd if=/usr/share/enna-recovery/nanda.bin of=/dev/nanda
echo "Recovery of (nandb)"
dd if=/usr/share/enna-recovery/nandb.bin of=/dev/nandb

echo "Formatting Home partition (nandc)"
/sbin/mkfs.ext4 /dev/nandc

for i in  `ls /*.pkg`
do
    if [ "x$i" -eq "xupdate.pkg" ]; then
        echo "Copy image on rootfs1 (nandd)"
        dd if=$i of=/dev/nandd
        echo "Copy image on rootfs2 (nande)"
        dd if=$i of=/dev/nande
        break
    fi
done

echo "Formatting updates partition (nandf)"
/sbin/mkfs.ext4 /dev/nandf



