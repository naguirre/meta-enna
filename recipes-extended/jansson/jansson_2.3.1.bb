DESCRIPTION = "Jansson is a C library for encoding, decoding and manipulating JSON data"
HOMEPAGE = "http://www.digip.org/jansson/"
PRIORITY = "optional"
PR = "r0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6946b728e700de875e60ebb453cc3a20"
SRC_URI[md5sum] = "28848fbc02d7657d930f97ce74f80d93"
SRC_URI[sha256sum] = "5f2ebf63580c73cc115634861b5da1c919499dde37d2e73b16e28b0c8ddc3921"
SRC_URI = "http://www.digip.org/jansson/releases/jansson-2.3.1.tar.gz"

inherit autotools pkgconfig

