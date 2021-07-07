# LPIC-1 Training Notes

https://learning.lpi.org/en/learning-materials/101-500/

- [LPIC-1 Training Notes](#lpic-1-training-notes)
  - [101.1-Determine and Configure Hardware Settings](#1011-determine-and-configure-hardware-settings)
    - [Device Inspection](#device-inspection)
    - [Commands for Inspection](#commands-for-inspection)
  - [101.2 - System Boot](#1012---system-boot)
  - [Grub Commands](#grub-commands)

## 101.1-Determine and Configure Hardware Settings

### Device Inspection

Check in UEFI/BIOS if something is not working correctly. If the hardware is not detected there, then the problem is almost certainly in the hardware or the port itself.
Otherwise, the issue is probably with the operating system.

### Commands for Inspection

`lspci` - Show all devices connected to the PCI bus (motherboard). Could be disk controller or expansion card (external gpu)  

`lsusb` - Show all devices connected to the machine VIA USB port  

Can use `-s` to show less information  

Can use `-d [id]` to display detailed info about one device

## 101.2 - System Boot

To access GRUB - Press `shift` while booting from BIOS, `esc` when booting from UEFI

## Grub Commands

- `acpi`: Enables/ disables ACPI support. `acpi=off` to disable support for acpi
- `init`: Sets an alternative initiator for the system. `init=/bin/bash` sets bash to the initiator so a shell session will start before OS
- `systemd.unit`: Sets systemd target to be activated. `systemd.unit=graphical.target`. To activate runlevel 1, just need `systemd.unit 1` or `systemd.unit S`
- `mem`: Sets amount of available ram. `mem=512M` limits ram to 512 MB
- `maxcpus`: limits number of cores visible. Value of 0 for non-multicore. `maxcpus=2` limites the number of processors to 2
- `quiet`: hides most boot messages
- `root`: Sets root partiton. `root=/dev/sda3`
- `ro`: makes initial mount of the root filesystem be read-only
- `rw`: allows writing in the initial boot of root filesystem
