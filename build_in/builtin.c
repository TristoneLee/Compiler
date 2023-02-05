#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void *__MALLOC(int size) {
  void *ptr;
  ptr = malloc(size);
  return ptr;
}

// * NORMAL
void __PRINT(char *str) { printf("%s", str); }

void __PRINTLN(char *str) { printf("%s\n", str); }

void __PRINT_INT(int val) { printf("%d", val); }

void __PRINTLN_INT(int val) { printf("%d\n", val); }

int __GET_SIZE(void *ptr) {
  void *ptr_ = ptr - 4;
  return *((int *)ptr);
}

char *__GET_STRING() {
  char *buf = (char *)malloc(256);
  scanf("%s", buf);
  return buf;
}

int __GET_INT() {
  int val;
  scanf("%d", &val);
  return val;
}

char *__TO_STRING(int val) {
  char *buf = (char *)malloc(12);
  sprintf(buf, "%d", val);
  return buf;
}

// * STRING
char *__STRING_ADD(char *str1, char *str2) {
  int len = strlen(str1) + strlen(str2);
  char *str = (char *)malloc(len + 1);
  strcpy(str, str1);
  strcat(str, str2);
  return str;
}

char __STRING_EQUAL(char *str1, char *str2) { return (strcmp(str1, str2) == 0); }

char __STRING_NOT_EQUAL(char *str1, char *str2) { return (strcmp(str1, str2) != 0); }

char __STRING_LESS(char *str1, char *str2) { return (strcmp(str1, str2) < 0); }

char __STRING_GREATER(char *str1, char *str2) { return (strcmp(str1, str2) > 0); }

char __STRING_LESS_EQUAL(char *str1, char *str2) { return (strcmp(str1, str2) <= 0); }

char __STRING_GREATER_EQUAL(char *str1, char *str2) { return (strcmp(str1, str2) >= 0); }

char *__STRING__SUBSTRING(char *str, int left, int right) {
  int len = right - left;
  char *substr = (char *)malloc(len + 1);
  memcpy(substr, str + left, len);
  substr[len] = '\0';
  return substr;
}

int __STRING_PARSE_INT(char *str) {
  int i;
  sscanf(str, "%d", &i);
  return i;
  ;
}

int __STRING_ORD(char *str, int pos) { return (int)str[pos]; }

int __STRING_LENGTH(char *str) { return strlen(str); }
