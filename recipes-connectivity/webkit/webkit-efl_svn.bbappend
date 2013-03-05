FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
PRINC := "${@int(PRINC) + 1}"

DEPENDS += "harfbuzz enchant virtual/libgl ruby-native"

SRCREV = "127150"
PV = "1.9.3+svnr${SRCREV}"
#http://builds.nightly.webkit.org/files/trunk/src/WebKit-r${SRCREV}.tar.bz2 

SRC_URI = "\
  http://packages.profusion.mobi/webkit-efl/webkit-efl-svn-r127150.tar.bz2 \
  file://CMakeLists.txt \
"
S = "${WORKDIR}/webkit-efl-svn-r${SRCREV}"

SRC_URI[md5sum] = "54332bd571a23d44e32837f4fa3a1c76"
SRC_URI[sha256sum] = "0fac75d0bb8efb20ee032484d48cfab2770c4a2d6a887105abacbf4f5acf3f33"

EXTRA_OECMAKE += "-DRUBY_EXECUTABLE=/usr/bin/ruby -DCMAKE_BUILD_TYPE=release"