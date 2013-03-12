DESCRIPTION = "Linux::Inotify2 - scalable directory/file change notification"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

LIC_FILES_CHKSUM = "file://COPYING;md5=043dba8b278e1db1b0ef93f30140b02b"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://backpan.perl.org/authors/id/M/ML/MLEHMANN/Linux-Inotify2-${PV}.tar.gz"

SRC_URI[md5sum] = "5aee608d90fc9a23df1edcf6d2c3ad4c"
SRC_URI[sha256sum] = "4dc0b8f10916961b71866b1e5bf36db1b115f3596f453e56f59185b2880b5b80"

S = "${WORKDIR}/Linux-Inotify2-${PV}"

inherit cpan

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/Linux/Inotify2/.debug/"
