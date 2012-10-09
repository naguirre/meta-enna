require lua.inc

PR="r4"

do_install() {
    install -m 0755 src/lua src/luac ${STAGING_BINDIR}/
}
