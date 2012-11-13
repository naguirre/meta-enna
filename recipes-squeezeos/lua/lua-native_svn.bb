require lua.inc

#inherit native

PR="r4"

do_install() {
    mkdir -p ${STAGING_BINDIR}/
    install -m 0755 src/lua src/luac ${STAGING_BINDIR}/
}
