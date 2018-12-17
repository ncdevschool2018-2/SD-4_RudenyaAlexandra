import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserData } from '../sharedData/user';
import { UserService } from '../service/user.service';
import {FormBuilder, FormGroup, Validator, Validators, FormControl, FormArray, ValidationErrors } from '@angular/forms';
import { MustMatch } from './mustMatch';
import * as moment from 'moment';
import { User } from '../model/user';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { LoginUser } from '../model/loginUser';
import { Token } from '../model/token';
import { TokenStorage } from '../core/token.srorage';

@Component({
    selector: 'app-signin-page',
    templateUrl: './signin-page.component.html',
    styleUrls: ['./signin-page.component.css']
})

export class SigninComponent implements OnInit, OnDestroy {
// tslint:disable-next-line:comment-format
//спросить про loginUser нужен ли ?
  v: true;
  user: UserData;
  results = false;
  // tslint:disable-next-line:comment-format
  registerForm: FormGroup;
  submitted = false;

  constructor(private userService: UserService,
    private loadingSpinnerService: Ng4LoadingSpinnerService,
     private formBuilder: FormBuilder,
     private router: Router, private auth: AuthService,
     private tokenStorage: TokenStorage) {
  }

  ngOnInit() {
    this.user = new UserData(this.userService, this.loadingSpinnerService);
    this.user.ngOnInit();
    this.registerForm = this.formBuilder.group({
      firstName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(20)]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(20)]),
      login: new FormControl('', [Validators.required, Validators.minLength(6), Validators.pattern('^[a-z0-9_-]{8,25}$')]),
      password: new FormControl('', [Validators.required, Validators.minLength(8), this.passwordValidator]),
      role: new FormControl( 1, [Validators.required]),
      confirmPassword: new FormControl('', [Validators.required, Validators.minLength(8)]),
        }, {
            validator: MustMatch('password', 'confirmPassword')
        });
  }

  public get f() {
    return this.registerForm.controls;
  }

  private passwordValidator(control: FormControl): ValidationErrors {
    const value = control.value;
    /** Проверка на содержание цифр */
    const hasNumber = /[0-9]/.test(value);
    /** Проверка на содержание заглавных букв */
    const hasCapitalLetter = /[A-Z]/.test(value);
    /** Проверка на содержание прописных букв */
    const hasLowercaseLetter = /[a-z]/.test(value);
   /** Общая проверка */
    const passwordValid = hasNumber && hasCapitalLetter && hasLowercaseLetter;
    if (!passwordValid) {
     return {invalid: 'Password unvalid'};
    }
     return null;
   }

   isLoginValidator(controlName: string): boolean {
      let result = false;
      const controls = this.registerForm.controls[controlName];
      for (let i = 0; i < this.user.userAccount.length ; i++) {
          // tslint:disable-next-line:triple-equals
          if (this.user.userAccount[i].login == controls.value) {
            result = true;
            break;
          }
      }
      return result;
  }

  forAuth(): LoginUser {
    const loginUser = new LoginUser();
    loginUser.login = this.registerForm.controls['login'].value;
    loginUser.password = this.registerForm.controls['password'].value;
    return loginUser;
  }
  onSubmit() {
    const controls = this.f;
    if (this.registerForm.invalid) {
      // tslint:disable-next-line:comment-format
      Object.keys(controls).forEach( controlName => controls[controlName].markAsTouched());
      return;
    }
    console.log(this.registerForm.value);
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.registerForm.controls[controlName];
    const result = control.invalid && control.touched;
    return result;
  }

  isInvalid(): boolean {
      if (this.registerForm.invalid || this.isLoginValidator('login')) {
        return true;
      }
      return false;
  }


  submit() {
    const registerFormControls = this.registerForm.controls;
    this.user.editUser.account.firstName = this.registerForm.controls['firstName'].value;
    this.user.editUser.account.lastName = this.registerForm.controls['lastName'].value;
    this.user.editUser.login = this.registerForm.controls['login'].value;
    this.user.editUser.role.roleId = this.registerForm.controls['role'].value;
    this.user.editUser.password = this.registerForm.controls['password'].value;
    this.user.editUser.account.registrationDate = moment().format('YYYY-MM-DD').toString();
    this.user._addUser();
  }

  getToken() {
    this.submit();
    this.auth.attempAuth(this.forAuth()).subscribe ( authToken => {
      // tslint:disable-next-line:prefer-const
      let token: Token = authToken as Token;
      this.tokenStorage.saveToken(token.token);
      if (this.tokenStorage.getToken() != null) {
        this.router.navigateByUrl('/account');
        window.location.reload();
      }
    });
  }

  ngOnDestroy(): void {
  }
}
