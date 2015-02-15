EXTRA_OEMAKE = "CC='${CC}' KERNEL_INCLUDE=${STAGING_INCDIR} DOCDIR=${docdir}/iproute2 SUBDIRS='lib tc ip bridge' SBINDIR='${base_sbindir}' LIBDIR='${libdir}'"


PACKAGES =+ "${PN}-bridge"
FILES_${PN}-bridge = "${base_sbindir}/bridge* \
                      ${libdir}/tc/*.so"

# The .so files in iproute2-bridge are modules, not traditional libraries
INSANE_SKIP_${PN}-bridge = "dev-so"

