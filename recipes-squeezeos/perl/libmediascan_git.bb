DESCRIPTION = "libmediascan is an evolution of the work done on the Perl modules Audio::Scan and Image::Scale"
SECTION = "libs"
LICENSE = "GPLv3"

SRCREV = "7b1501e859cf9bd1eb569d476dca158121ef7fe8"
PR = "1"

LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

# This should match the version currently listed in SBS's modules.conf file
SRC_URI = "git://github.com/andygrundman/libmediascan.git;protocol=http;branch=master"

S = "${WORKDIR}/git"

inherit autotools





