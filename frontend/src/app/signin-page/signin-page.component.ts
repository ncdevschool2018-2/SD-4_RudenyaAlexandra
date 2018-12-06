import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserData } from '../sharedData/user';
import { UserService } from '../service/user.service';
import {FormBuilder, FormGroup, Validator, Validators, FormControl, FormArray } from '@angular/forms';
import { MustMatch } from './MustMatch';
import { User } from '../model/user';
import { Account } from '../model/account';

@Component({
    selector: 'app-signin-page',
    templateUrl: './signin-page.component.html',
    styleUrls: ['./signin-page.component.css']
})

export class SigninComponent implements OnInit, OnDestroy {
// tslint:disable-next-line:comment-format
//спросить про loginUser нужен ли ?
  public v: true;
  public user = new UserData(this.userService);
  // tslint:disable-next-line:comment-format
  registerForm: FormGroup;
  submitted = false;

  constructor(private userService: UserService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.user.ngOnInit();
    this.registerForm = this.formBuilder.group({
      firstName: new FormControl('', [Validators.required, Validators.minLength(2)]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(2)]),
      login: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(8)]),
      role: new FormControl( 1, [Validators.required]),
      confirmPassword: new FormControl('', [Validators.required, Validators.minLength(8)]),
        }, {
            validator: MustMatch('password', 'confirmPassword')
        });
  }

  public get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    const controls = this.f;
    if (this.registerForm.invalid) {
      // tslint:disable-next-line:comment-format
      Object.keys(controls).forEach( controlName => controls[controlName].markAsTouched());
      return;
    }
    console.log(this.registerForm.value);
    /*console.log('email=' + this.f.email.value);
    console.log('username=' + this.f.username.value);
    console.log('password=' + this.f.password.value);*/
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.registerForm.controls[controlName];
    const result = control.invalid && control.touched;
    return result;
  }


  submit() {
    const registerFormControls = this.registerForm.controls;
    this.user.editUser.account.firstName = this.registerForm.controls['firstName'].value;
    this.user.editUser.account.lastName = this.registerForm.controls['lastName'].value;
    this.user.editUser.login = this.registerForm.controls['login'].value;
    this.user.editUser.role.roleId = this.registerForm.controls['role'].value;
    this.user.editUser.password = this.registerForm.controls['password'].value;
    this.user._addUser();
  }

  ngOnDestroy(): void {
  }
}
