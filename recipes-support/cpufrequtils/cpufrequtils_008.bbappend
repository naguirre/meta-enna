FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC = "1"

CFLAGS_append_armv7ahf = "  -mfloat-abi=hard "
