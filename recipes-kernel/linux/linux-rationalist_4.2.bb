# Based on linux-yocto-custom.bb:
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   defconfig: When a defconfig is provided, the linux-yocto configuration
#              uses the filename as a trigger to use a 'allnoconfig' baseline
#              before merging the defconfig into the build. 
#
#              If the defconfig file was created with make_savedefconfig, 
#              not all options are specified, and should be restored with their
#              defaults, not set to 'n'. To properly expand a defconfig like
#              this, specify: KCONFIG_MODE="--alldefconfig" in the kernel
#              recipe.
#   
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition (for kernel v3.4 only):
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition (for kernel v3.4 only):
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc
KBRANCH = "linux-4.2.y"

# Override SRC_URI in a bbappend file to point at a different source
# tree if you do not want to build from Linus' tree.
#SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;nocheckout=1;name=machine"
#SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;name=machine"
SRC_URI = "git:///mnt/devel/git-repos/linux-stable.git;protocol=file;branch=${KBRANCH};nocheckout=1;name=machine"

SRC_URI += "file://defconfig"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#LINUX_VERSION = "3.19"
LINUX_VERSION = "4.2.5"
LINUX_VERSION_EXTENSION = "-rationalist"

# Override SRCREV to point to a different commit in a bbappend file to
# build a different release of the Linux kernel.
# tag: v3.4 76e10d158efb6d4516018846f60c2ab5501900bc
#SRCREV = "96e199f1751e707a7a8c04d9b079f84df2e0d4ff"
SRCREV = "fcba09f2b0bf27eeaa1d4d439edb649585f35040"

PR = "r2"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "mousetrap_hw"

