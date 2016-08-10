<#include "macro/taskList.ftl"/>
<#include "modal.ftl"/>
<#import "layout.ftl" as myLayout>
<@myLayout.masterPage>

<form class="form-signin" role="form" action="/login" method="post">

    <h4>Login with: demo@localhost / demo</h4>

    <h2 class="form-signin-heading">Task Manager</h2>

    <label for="email" class="sr-only">Email address</label>
    <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>

    <label for="password" class="sr-only">Password</label>
    <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>

    <div class="checkbox">
        <label>
            <input type="checkbox" value="remember-me" id="remember-me"> Remember me
        </label>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

    <#if error.isPresent()>
        <p>The email or password you have entered is invalid, try again.</p>
    </#if>
</form>

</@myLayout.masterPage>
