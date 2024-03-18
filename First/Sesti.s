	.file	"Sesti.cpp"
	.intel_syntax noprefix
	.text
	.section	.text._ZN4BaseC2Ei,"axG",@progbits,_ZN4BaseC5Ei,comdat
	.align 2
	.weak	_ZN4BaseC2Ei
	.type	_ZN4BaseC2Ei, @function
_ZN4BaseC2Ei:
.LFB1:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	QWORD PTR -8[rbp], rdi
	mov	DWORD PTR -12[rbp], esi
	lea	rdx, _ZTV4Base[rip+16]
	mov	rax, QWORD PTR -8[rbp]
	mov	QWORD PTR [rax], rdx
	mov	rax, QWORD PTR -8[rbp]
	mov	edx, DWORD PTR -12[rbp]
	mov	DWORD PTR 8[rax], edx
	mov	rax, QWORD PTR -8[rbp]
	mov	rdi, rax
	call	_ZN4Base6metodaEv
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1:
	.size	_ZN4BaseC2Ei, .-_ZN4BaseC2Ei
	.weak	_ZN4BaseC1Ei
	.set	_ZN4BaseC1Ei,_ZN4BaseC2Ei
	.section	.rodata
.LC0:
	.string	"EEEObicna"
	.section	.text._ZN4Base15virtualnaMetodaEv,"axG",@progbits,_ZN4Base15virtualnaMetodaEv,comdat
	.align 2
	.weak	_ZN4Base15virtualnaMetodaEv
	.type	_ZN4Base15virtualnaMetodaEv, @function
_ZN4Base15virtualnaMetodaEv:
.LFB3:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	QWORD PTR -8[rbp], rdi
	lea	rax, .LC0[rip]
	mov	rdi, rax
	mov	eax, 0
	call	printf@PLT
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE3:
	.size	_ZN4Base15virtualnaMetodaEv, .-_ZN4Base15virtualnaMetodaEv
	.section	.rodata
.LC1:
	.string	"Metoda kaze: "
	.section	.text._ZN4Base6metodaEv,"axG",@progbits,_ZN4Base6metodaEv,comdat
	.align 2
	.weak	_ZN4Base6metodaEv
	.type	_ZN4Base6metodaEv, @function
_ZN4Base6metodaEv:
.LFB4:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	QWORD PTR -8[rbp], rdi
	lea	rax, .LC1[rip]
	mov	rdi, rax
	mov	eax, 0
	call	printf@PLT
	mov	rax, QWORD PTR -8[rbp]
	mov	rax, QWORD PTR [rax]
	mov	rdx, QWORD PTR [rax]
	mov	rax, QWORD PTR -8[rbp]
	mov	rdi, rax
	call	rdx
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE4:
	.size	_ZN4Base6metodaEv, .-_ZN4Base6metodaEv
	.section	.text._ZN7DerivedC2Eii,"axG",@progbits,_ZN7DerivedC5Eii,comdat
	.align 2
	.weak	_ZN7DerivedC2Eii
	.type	_ZN7DerivedC2Eii, @function
_ZN7DerivedC2Eii:
.LFB6:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	QWORD PTR -8[rbp], rdi
	mov	DWORD PTR -12[rbp], esi
	mov	DWORD PTR -16[rbp], edx
	mov	rax, QWORD PTR -8[rbp]
	mov	edx, DWORD PTR -12[rbp]
	mov	esi, edx
	mov	rdi, rax
	call	_ZN4BaseC2Ei
	lea	rdx, _ZTV7Derived[rip+16]
	mov	rax, QWORD PTR -8[rbp]
	mov	QWORD PTR [rax], rdx
	mov	rax, QWORD PTR -8[rbp]
	mov	edx, DWORD PTR -16[rbp]
	mov	DWORD PTR 12[rax], edx
	mov	rax, QWORD PTR -8[rbp]
	mov	rdi, rax
	call	_ZN4Base6metodaEv
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE6:
	.size	_ZN7DerivedC2Eii, .-_ZN7DerivedC2Eii
	.weak	_ZN7DerivedC1Eii
	.set	_ZN7DerivedC1Eii,_ZN7DerivedC2Eii
	.section	.rodata
.LC2:
	.string	"%d%d"
	.align 8
.LC3:
	.string	"ja sam izvedena implementacija!"
	.section	.text._ZN7Derived15virtualnaMetodaEv,"axG",@progbits,_ZN7Derived15virtualnaMetodaEv,comdat
	.align 2
	.weak	_ZN7Derived15virtualnaMetodaEv
	.type	_ZN7Derived15virtualnaMetodaEv, @function
_ZN7Derived15virtualnaMetodaEv:
.LFB8:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	QWORD PTR -8[rbp], rdi
	mov	rax, QWORD PTR -8[rbp]
	mov	rdi, rax
	call	_ZN4Base15virtualnaMetodaEv
	mov	rax, QWORD PTR -8[rbp]
	mov	edx, DWORD PTR 12[rax]
	mov	rax, QWORD PTR -8[rbp]
	mov	eax, DWORD PTR 8[rax]
	mov	esi, eax
	lea	rax, .LC2[rip]
	mov	rdi, rax
	mov	eax, 0
	call	printf@PLT
	lea	rax, .LC3[rip]
	mov	rdi, rax
	call	puts@PLT
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE8:
	.size	_ZN7Derived15virtualnaMetodaEv, .-_ZN7Derived15virtualnaMetodaEv
	.section	.text._ZN7Derived4nekaEv,"axG",@progbits,_ZN7Derived4nekaEv,comdat
	.align 2
	.weak	_ZN7Derived4nekaEv
	.type	_ZN7Derived4nekaEv, @function
_ZN7Derived4nekaEv:
.LFB9:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	QWORD PTR -8[rbp], rdi
	lea	rax, .LC3[rip]
	mov	rdi, rax
	call	puts@PLT
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE9:
	.size	_ZN7Derived4nekaEv, .-_ZN7Derived4nekaEv
	.text
	.globl	main
	.type	main, @function
main:
.LFB10:
	.cfi_startproc
	.cfi_personality 0x9b,DW.ref.__gxx_personality_v0
	.cfi_lsda 0x1b,.LLSDA10
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	push	r12
	push	rbx
	sub	rsp, 16
	.cfi_offset 12, -24
	.cfi_offset 3, -32
	mov	edi, 16
.LEHB0:
	call	_Znwm@PLT
.LEHE0:
	mov	rbx, rax
	mov	edx, 5
	mov	esi, 2
	mov	rdi, rbx
.LEHB1:
	call	_ZN7DerivedC1Eii
.LEHE1:
	mov	QWORD PTR -24[rbp], rbx
	mov	rax, QWORD PTR -24[rbp]
	mov	rdi, rax
.LEHB2:
	call	_ZN4Base6metodaEv
	mov	eax, 0
	jmp	.L11
.L10:
	endbr64
	mov	r12, rax
	mov	esi, 16
	mov	rdi, rbx
	call	_ZdlPvm@PLT
	mov	rax, r12
	mov	rdi, rax
	call	_Unwind_Resume@PLT
.LEHE2:
.L11:
	add	rsp, 16
	pop	rbx
	pop	r12
	pop	rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE10:
	.globl	__gxx_personality_v0
	.section	.gcc_except_table,"a",@progbits
.LLSDA10:
	.byte	0xff
	.byte	0xff
	.byte	0x1
	.uleb128 .LLSDACSE10-.LLSDACSB10
.LLSDACSB10:
	.uleb128 .LEHB0-.LFB10
	.uleb128 .LEHE0-.LEHB0
	.uleb128 0
	.uleb128 0
	.uleb128 .LEHB1-.LFB10
	.uleb128 .LEHE1-.LEHB1
	.uleb128 .L10-.LFB10
	.uleb128 0
	.uleb128 .LEHB2-.LFB10
	.uleb128 .LEHE2-.LEHB2
	.uleb128 0
	.uleb128 0
.LLSDACSE10:
	.text
	.size	main, .-main
	.weak	_ZTV7Derived
	.section	.data.rel.ro.local._ZTV7Derived,"awG",@progbits,_ZTV7Derived,comdat
	.align 8
	.type	_ZTV7Derived, @object
	.size	_ZTV7Derived, 32
_ZTV7Derived:
	.quad	0
	.quad	_ZTI7Derived
	.quad	_ZN7Derived15virtualnaMetodaEv
	.quad	_ZN7Derived4nekaEv
	.weak	_ZTV4Base
	.section	.data.rel.ro._ZTV4Base,"awG",@progbits,_ZTV4Base,comdat
	.align 8
	.type	_ZTV4Base, @object
	.size	_ZTV4Base, 32
_ZTV4Base:
	.quad	0
	.quad	_ZTI4Base
	.quad	_ZN4Base15virtualnaMetodaEv
	.quad	__cxa_pure_virtual
	.weak	_ZTI7Derived
	.section	.data.rel.ro._ZTI7Derived,"awG",@progbits,_ZTI7Derived,comdat
	.align 8
	.type	_ZTI7Derived, @object
	.size	_ZTI7Derived, 24
_ZTI7Derived:
	.quad	_ZTVN10__cxxabiv120__si_class_type_infoE+16
	.quad	_ZTS7Derived
	.quad	_ZTI4Base
	.weak	_ZTS7Derived
	.section	.rodata._ZTS7Derived,"aG",@progbits,_ZTS7Derived,comdat
	.align 8
	.type	_ZTS7Derived, @object
	.size	_ZTS7Derived, 9
_ZTS7Derived:
	.string	"7Derived"
	.weak	_ZTI4Base
	.section	.data.rel.ro._ZTI4Base,"awG",@progbits,_ZTI4Base,comdat
	.align 8
	.type	_ZTI4Base, @object
	.size	_ZTI4Base, 16
_ZTI4Base:
	.quad	_ZTVN10__cxxabiv117__class_type_infoE+16
	.quad	_ZTS4Base
	.weak	_ZTS4Base
	.section	.rodata._ZTS4Base,"aG",@progbits,_ZTS4Base,comdat
	.type	_ZTS4Base, @object
	.size	_ZTS4Base, 6
_ZTS4Base:
	.string	"4Base"
	.weak	__cxa_pure_virtual
	.hidden	DW.ref.__gxx_personality_v0
	.weak	DW.ref.__gxx_personality_v0
	.section	.data.rel.local.DW.ref.__gxx_personality_v0,"awG",@progbits,DW.ref.__gxx_personality_v0,comdat
	.align 8
	.type	DW.ref.__gxx_personality_v0, @object
	.size	DW.ref.__gxx_personality_v0, 8
DW.ref.__gxx_personality_v0:
	.quad	__gxx_personality_v0
	.ident	"GCC: (Ubuntu 11.3.0-1ubuntu1~22.04) 11.3.0"
	.section	.note.GNU-stack,"",@progbits
	.section	.note.gnu.property,"a"
	.align 8
	.long	1f - 0f
	.long	4f - 1f
	.long	5
0:
	.string	"GNU"
1:
	.align 8
	.long	0xc0000002
	.long	3f - 2f
2:
	.long	0x3
3:
	.align 8
4:
