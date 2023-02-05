	.file	"builtin.c"
	.option nopic
	.attribute arch, "rv32i2p0"
	.attribute unaligned_access, 0
	.attribute stack_align, 16
	.text
	.align	2
	.globl	__MALLOC
	.type	__MALLOC, @function
__MALLOC:
	tail	malloc
	.size	__MALLOC, .-__MALLOC
	.section	.rodata.str1.4,"aMS",@progbits,1
	.align	2
.LC0:
	.string	"%s"
	.text
	.align	2
	.globl	__PRINT
	.type	__PRINT, @function
__PRINT:
	mv	a1,a0
	lui	a0,%hi(.LC0)
	addi	a0,a0,%lo(.LC0)
	tail	printf
	.size	__PRINT, .-__PRINT
	.align	2
	.globl	__PRINTLN
	.type	__PRINTLN, @function
__PRINTLN:
	tail	puts
	.size	__PRINTLN, .-__PRINTLN
	.section	.rodata.str1.4
	.align	2
.LC1:
	.string	"%d"
	.text
	.align	2
	.globl	__PRINT_INT
	.type	__PRINT_INT, @function
__PRINT_INT:
	mv	a1,a0
	lui	a0,%hi(.LC1)
	addi	a0,a0,%lo(.LC1)
	tail	printf
	.size	__PRINT_INT, .-__PRINT_INT
	.section	.rodata.str1.4
	.align	2
.LC2:
	.string	"%d\n"
	.text
	.align	2
	.globl	__PRINTLN_INT
	.type	__PRINTLN_INT, @function
__PRINTLN_INT:
	mv	a1,a0
	lui	a0,%hi(.LC2)
	addi	a0,a0,%lo(.LC2)
	tail	printf
	.size	__PRINTLN_INT, .-__PRINTLN_INT
	.align	2
	.globl	__GET_SIZE
	.type	__GET_SIZE, @function
__GET_SIZE:
	lw	a0,0(a0)
	ret
	.size	__GET_SIZE, .-__GET_SIZE
	.align	2
	.globl	__GET_STRING
	.type	__GET_STRING, @function
__GET_STRING:
	addi	sp,sp,-16
	li	a0,256
	sw	ra,12(sp)
	sw	s0,8(sp)
	call	malloc
	mv	s0,a0
	mv	a1,a0
	lui	a0,%hi(.LC0)
	addi	a0,a0,%lo(.LC0)
	call	scanf
	lw	ra,12(sp)
	mv	a0,s0
	lw	s0,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	__GET_STRING, .-__GET_STRING
	.align	2
	.globl	__GET_INT
	.type	__GET_INT, @function
__GET_INT:
	addi	sp,sp,-32
	lui	a0,%hi(.LC1)
	addi	a1,sp,12
	addi	a0,a0,%lo(.LC1)
	sw	ra,28(sp)
	call	scanf
	lw	ra,28(sp)
	lw	a0,12(sp)
	addi	sp,sp,32
	jr	ra
	.size	__GET_INT, .-__GET_INT
	.align	2
	.globl	__TO_STRING
	.type	__TO_STRING, @function
__TO_STRING:
	addi	sp,sp,-16
	sw	s1,4(sp)
	mv	s1,a0
	li	a0,12
	sw	ra,12(sp)
	sw	s0,8(sp)
	call	malloc
	lui	a1,%hi(.LC1)
	mv	a2,s1
	addi	a1,a1,%lo(.LC1)
	mv	s0,a0
	call	sprintf
	lw	ra,12(sp)
	mv	a0,s0
	lw	s0,8(sp)
	lw	s1,4(sp)
	addi	sp,sp,16
	jr	ra
	.size	__TO_STRING, .-__TO_STRING
	.align	2
	.globl	__STRING_ADD
	.type	__STRING_ADD, @function
__STRING_ADD:
	addi	sp,sp,-32
	sw	ra,28(sp)
	sw	s0,24(sp)
	sw	s1,20(sp)
	sw	s2,16(sp)
	sw	s3,12(sp)
	sw	s4,8(sp)
	mv	s2,a1
	mv	s4,a0
	call	strlen
	mv	s0,a0
	mv	a0,s2
	call	strlen
	mv	s3,a0
	add	a0,s0,a0
	addi	a0,a0,1
	call	malloc
	mv	a2,s0
	mv	a1,s4
	mv	s1,a0
	call	memcpy
	add	a0,s1,s0
	addi	a2,s3,1
	mv	a1,s2
	call	memcpy
	lw	ra,28(sp)
	lw	s0,24(sp)
	lw	s2,16(sp)
	lw	s3,12(sp)
	lw	s4,8(sp)
	mv	a0,s1
	lw	s1,20(sp)
	addi	sp,sp,32
	jr	ra
	.size	__STRING_ADD, .-__STRING_ADD
	.align	2
	.globl	__STRING_EQUAL
	.type	__STRING_EQUAL, @function
__STRING_EQUAL:
	addi	sp,sp,-16
	sw	ra,12(sp)
	call	strcmp
	lw	ra,12(sp)
	seqz	a0,a0
	addi	sp,sp,16
	jr	ra
	.size	__STRING_EQUAL, .-__STRING_EQUAL
	.align	2
	.globl	__STRING_NOT_EQUAL
	.type	__STRING_NOT_EQUAL, @function
__STRING_NOT_EQUAL:
	addi	sp,sp,-16
	sw	ra,12(sp)
	call	strcmp
	lw	ra,12(sp)
	snez	a0,a0
	addi	sp,sp,16
	jr	ra
	.size	__STRING_NOT_EQUAL, .-__STRING_NOT_EQUAL
	.align	2
	.globl	__STRING_LESS
	.type	__STRING_LESS, @function
__STRING_LESS:
	addi	sp,sp,-16
	sw	ra,12(sp)
	call	strcmp
	lw	ra,12(sp)
	srli	a0,a0,31
	addi	sp,sp,16
	jr	ra
	.size	__STRING_LESS, .-__STRING_LESS
	.align	2
	.globl	__STRING_GREATER
	.type	__STRING_GREATER, @function
__STRING_GREATER:
	addi	sp,sp,-16
	sw	ra,12(sp)
	call	strcmp
	lw	ra,12(sp)
	sgt	a0,a0,zero
	addi	sp,sp,16
	jr	ra
	.size	__STRING_GREATER, .-__STRING_GREATER
	.align	2
	.globl	__STRING_LESS_EQUAL
	.type	__STRING_LESS_EQUAL, @function
__STRING_LESS_EQUAL:
	addi	sp,sp,-16
	sw	ra,12(sp)
	call	strcmp
	lw	ra,12(sp)
	slti	a0,a0,1
	addi	sp,sp,16
	jr	ra
	.size	__STRING_LESS_EQUAL, .-__STRING_LESS_EQUAL
	.align	2
	.globl	__STRING_GREATER_EQUAL
	.type	__STRING_GREATER_EQUAL, @function
__STRING_GREATER_EQUAL:
	addi	sp,sp,-16
	sw	ra,12(sp)
	call	strcmp
	lw	ra,12(sp)
	not	a0,a0
	srli	a0,a0,31
	addi	sp,sp,16
	jr	ra
	.size	__STRING_GREATER_EQUAL, .-__STRING_GREATER_EQUAL
	.align	2
	.globl	__STRING__SUBSTRING
	.type	__STRING__SUBSTRING, @function
__STRING__SUBSTRING:
	addi	sp,sp,-32
	sw	s0,24(sp)
	sub	s0,a2,a1
	sw	s3,12(sp)
	mv	s3,a0
	addi	a0,s0,1
	sw	ra,28(sp)
	sw	s1,20(sp)
	sw	s2,16(sp)
	mv	s2,a1
	call	malloc
	mv	s1,a0
	add	a1,s3,s2
	mv	a2,s0
	add	s0,s1,s0
	call	memcpy
	sb	zero,0(s0)
	lw	ra,28(sp)
	lw	s0,24(sp)
	lw	s2,16(sp)
	lw	s3,12(sp)
	mv	a0,s1
	lw	s1,20(sp)
	addi	sp,sp,32
	jr	ra
	.size	__STRING__SUBSTRING, .-__STRING__SUBSTRING
	.align	2
	.globl	__STRING_PARSE_INT
	.type	__STRING_PARSE_INT, @function
__STRING_PARSE_INT:
	addi	sp,sp,-32
	lui	a1,%hi(.LC1)
	addi	a2,sp,12
	addi	a1,a1,%lo(.LC1)
	sw	ra,28(sp)
	call	sscanf
	lw	ra,28(sp)
	lw	a0,12(sp)
	addi	sp,sp,32
	jr	ra
	.size	__STRING_PARSE_INT, .-__STRING_PARSE_INT
	.align	2
	.globl	__STRING_ORD
	.type	__STRING_ORD, @function
__STRING_ORD:
	add	a0,a0,a1
	lbu	a0,0(a0)
	ret
	.size	__STRING_ORD, .-__STRING_ORD
	.align	2
	.globl	__STRING_LENGTH
	.type	__STRING_LENGTH, @function
__STRING_LENGTH:
	tail	strlen
	.size	__STRING_LENGTH, .-__STRING_LENGTH
	.ident	"GCC: (GNU) 10.1.0"
